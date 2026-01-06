package com.example.RockPaperScissor.Services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.RockPaperScissor.Models.Move;

@Service
public class GameServices {
	
	public String getComputerMove() {
        Move[] moves = Move.values();
        Random r = new Random();
        return moves[r.nextInt(moves.length)].name();
    }
	
	public String getResult(String cm, String pm) {
		String result ="";
		if (pm.equals(cm)) {
            result = "Égalité !";
        } else if (
            (pm.equals("ROCK") && cm.equals("SCISSORS")) ||
            (pm.equals("SCISSORS") && cm.equals("PAPER")) ||
            (pm.equals("PAPER") && cm.equals("ROCK"))
        ) {
            result = "Vous avez gagné !";
        } else {
            result = "Vous avez perdu !";
        }
		return result;
		
	}
}
