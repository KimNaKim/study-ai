package com.example.demo.reply;

import lombok.Data;

public class ReplyResponse {
    @Data
    public static class DTO {
        private Long id;
        private String comment;

        public DTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
        }
    }
}