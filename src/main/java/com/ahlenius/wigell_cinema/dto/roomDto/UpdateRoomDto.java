package com.ahlenius.wigell_cinema.dto.roomDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateRoomDto(
        @NotBlank(message = "Ange rummets namn.")
        String name,
        @NotNull(message = "Ange max. antal gäster.")
        @Min(5) @Max(245)
        int maxGuest,
        String equipment
) {
}
