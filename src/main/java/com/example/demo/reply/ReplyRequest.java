package com.example.demo.reply;

import lombok.Data;

public class ReplyRequest {
    @Data
    public static class SaveDTO {
        private Long boardId;
        private String comment;
    }
}