package com.taktika.iera.dto;

import java.util.List;

public class PostsListDto {

    private int totalPosts;
    private List<PostDtoImg> postsListDto;

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public List<PostDtoImg> getPostsListDto() {
        return postsListDto;
    }

    public void setPostsListDto(List<PostDtoImg> postsListDto) {
        this.postsListDto = postsListDto;
    }
}
