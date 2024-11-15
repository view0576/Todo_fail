package org.example.springexpert.domain.manager.dto.request;

import lombok.Getter;

@Getter
public class ManagerSaveRequestDto {

    private Long todoUserId; // 작성자 userId
    private Long managerUserId; // 담당자 userId
}
