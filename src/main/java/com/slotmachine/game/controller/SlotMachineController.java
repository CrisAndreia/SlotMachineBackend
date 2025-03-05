package com.leovegas.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.leovegas.game.service.SlotMachineService;
import com.leovegas.game.dto.*;

@RestController
@RequestMapping("/api/slot-machine")
public class SlotMachineController {
    private final SlotMachineService slotMachineService;

    @Autowired
    public SlotMachineController(SlotMachineService slotMachineService) {
        this.slotMachineService = slotMachineService;
    }

    // Endpoint to play
    @PostMapping("/play")
    public ResponseEntity<SlotResultResponse> playSlot(@Valid @RequestBody SlotPlayRequest playRequest) {
        SlotResultResponse result = slotMachineService.playSlot(playRequest);
        return ResponseEntity.ok(result);
    }

    // Endpoint to check user's credit
    @GetMapping("/balance/{userId}")
    public ResponseEntity<UserBalanceResponse> getBalance(@PathVariable String userId) {
        UserBalanceResponse balance = slotMachineService.getUserBalance(userId);
        return ResponseEntity.ok(balance);
    }
}
