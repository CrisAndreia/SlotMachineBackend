package com.leovegas.game.service;

import com.leovegas.game.repository.*;
import com.leovegas.game.dto.SlotResultResponse;
import com.leovegas.game.dto.SlotPlayRequest;
import com.leovegas.game.model.User;
import com.leovegas.game.dto.UserBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class SlotMachineService {

    @Qualifier("userMongoRepository")
    private final UserRepository userRepository;

    @Autowired
    public SlotMachineService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public SlotResultResponse playSlot(SlotPlayRequest playRequest){
        User user = userRepository.findById(playRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(playRequest.getBetAmount().compareTo(user.getBalance()) > 0){
            throw new RuntimeException("Insufficient balance, please top up to keep playing.");
        }

        //Substracts the bet from the user's account
        user.setBalance(user.getBalance().subtract(playRequest.getBetAmount()));
        userRepository.save(user);

        //Generates variables and calculates result
        String[][] reels = generateReels();
        BigDecimal winnings = calculateWinnings(reels, playRequest.getBetAmount());
        
        //Update the winnings to the balance
        user.setBalance(user.getBalance().add(winnings));
        userRepository.save(user);

        // Check if the user won
        boolean isWinner = winnings.compareTo(BigDecimal.ZERO) > 0;
        //boolean isWinner = true;
        //Return result
        return new SlotResultResponse(reels, winnings, user.getBalance(), isWinner);
    }

    /*@Component
    public class DataInitializer implements CommandLineRunner {

        @Autowired
        private UserRepository userRepository;

        @Override
        public void run(String... args) throws Exception {
            if (userRepository.count() == 0) {
                User user = new User();
                user.setUserId("123");
                user.setUserName("testuser");
                user.setBalance(BigDecimal.valueOf(10000000));
                //user.setPassword("testpassword");
                userRepository.save(user);
                System.out.println("Standart user test have been created");
            }
        }
    }*/

    public UserBalanceResponse getUserBalance(String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserBalanceResponse(user.getUserId(), user.getBalance());
    }

    private String[][] generateReels(){
        //game's symbols
        String[] symbols = {"🍒", "🍋", "🍉", "⭐", "🔔"};
        String[][] reels = new String[3][3];

        Random random = new Random();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                reels[i][j] = symbols[random.nextInt(symbols.length)];
            }
        }
        return reels;
    }

    private BigDecimal calculateWinnings(String [][] reels, BigDecimal betAmount){
        //Basic payment for combinations
        if (reels[0][0].equals(reels[0][1]) && reels[0][0].equals(reels[0][2])) {
            return betAmount.multiply(BigDecimal.valueOf(10));
        }
        if (reels[1][0].equals(reels[1][1]) && reels[1][0].equals(reels[1][2])) {

            return betAmount.multiply((BigDecimal.valueOf(5)));
        }
        return BigDecimal.ZERO;
    }
}
