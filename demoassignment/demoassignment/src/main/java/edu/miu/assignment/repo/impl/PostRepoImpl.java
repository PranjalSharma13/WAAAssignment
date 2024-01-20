//package edu.miu.assignment.repo.impl;
//
//import edu.miu.assignment.entity.Post;
//import edu.miu.assignment.repo.PostRepo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PostRepoImpl implements PostRepo {
//    @Override
//    public List<Post> findAll() {
//        return null;
//    }
//    private static List<Post> posts=new ArrayList<>();
//    static {
//        posts.add(new Post(1L, "First Post", "This is the content of the first post.", "Author1"));
//        posts.add(new Post(2L, "Second Post", "This is the content of the second post.", "Author2"));
//        posts.add(new Post(3L, "Third Post", "This is the content of the third post.", "Author3"));
//    }
//    @Override
//    public Post findPostById(long id)
//    {
//    return  posts.stream().filter(l->l.getId()==id).findFirst().orElse(null);
//
//    }
//
//    @Override
//    public void addPost(Post post)
//    {
////        posts.add(post);
//    }
//}
