package app.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public enum StatusResponse {
    SUCCESS("Success"),
    ERROR("Error");

    private String status;
}
