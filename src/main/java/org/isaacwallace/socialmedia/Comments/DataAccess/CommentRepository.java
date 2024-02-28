package org.isaacwallace.socialmedia.Comments.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public Comment findCommentByCommentIdentifier_Commentid(String commentid);
    public List<Comment> findCommentsByPostid(String postid);
    public List<Comment> findCommentsByUserid(String userid);
}
