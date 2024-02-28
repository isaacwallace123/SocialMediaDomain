package org.isaacwallace.socialmedia.Posts.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    public Post findPostByPostIdentifier_Postid(String postid);
    public List<Post> findPostsByUserid(String userid);
}