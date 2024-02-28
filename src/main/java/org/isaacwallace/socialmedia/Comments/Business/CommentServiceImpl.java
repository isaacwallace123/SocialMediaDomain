package org.isaacwallace.socialmedia.Comments.Business;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Comments.DataAccess.CommentIdentifier;
import org.isaacwallace.socialmedia.Comments.DataAccess.CommentRepository;
import org.isaacwallace.socialmedia.Comments.Mapper.CommentRequestMapper;
import org.isaacwallace.socialmedia.Comments.Mapper.CommentResponseMapper;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentRequestModel;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentResponseMapper commentResponseMapper;
    private final CommentRequestMapper commentRequestMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentResponseMapper commentResponseMapper, CommentRequestMapper commentRequestMapper) {
        this.commentRepository = commentRepository;
        this.commentResponseMapper = commentResponseMapper;
        this.commentRequestMapper = commentRequestMapper;
    }

    public List<CommentResponseModel> getAllComments() {
        return this.commentResponseMapper.entityListToResponseModelList(this.commentRepository.findAll());
    }
    public CommentResponseModel getCommentById(String commentid) {
        Comment comment = this.commentRepository.findCommentByCommentIdentifier_Commentid(commentid);

        if (comment == null) {
            throw new InvalidInputException("Unknown commentid: " + commentid);
        }

        return this.commentResponseMapper.entityToResponseModel(comment);
    }

    public CommentResponseModel addComment(CommentRequestModel commentRequestModel) {
        Comment newComment = this.commentRequestMapper.requestModelToEntity(commentRequestModel, new CommentIdentifier());

        return this.commentResponseMapper.entityToResponseModel(newComment);
    }

    public CommentResponseModel editComment(String commentid, CommentRequestModel commentRequestModel) {
        Comment comment = this.commentRepository.findCommentByCommentIdentifier_Commentid(commentid);

        if (comment == null) {
            throw new InvalidInputException("Unknown postid: " + commentid);
        }

        Comment updatedComment = this.commentRequestMapper.requestModelToEntity(commentRequestModel, comment.getCommentIdentifier());

        this.commentRepository.save(updatedComment);

        return this.commentResponseMapper.entityToResponseModel(updatedComment);
    }

    public void deleteComment(String commentid) {
        Comment comment = this.commentRepository.findCommentByCommentIdentifier_Commentid(commentid);

        if (comment == null) {
            throw new InvalidInputException("Unknown commentid: " + commentid);
        }

        try {
            this.commentRepository.delete(comment);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("Comment is in use by another entity, currently cannot delete.");
        }
    }
}
