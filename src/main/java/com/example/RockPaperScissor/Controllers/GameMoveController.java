package com.example.RockPaperScissor.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RockPaperScissor.Services.GameServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GameMoveController {
		@Autowired
		GameServices gs;
		
		@PostMapping("/play")
	    public ResponseEntity<Map<String, String>> play(@RequestBody Map<String, String> userMove) {
	        String pm = userMove.get("pm");
	        String cm = gs.getComputerMove();
	        String result = gs.getResult(cm, pm);

	        Map<String, String> response = new HashMap<>();
	        response.put("player", pm);
	        response.put("computer", cm);
	        response.put("result", result);

	        return ResponseEntity.ok(response);
	    }
}
