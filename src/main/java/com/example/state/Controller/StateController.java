package com.example.state.Controller;

import com.example.state.Model.State;
import com.example.state.Service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StateController {

    private final StateService stateService;

   public StateController(StateService stateService){
       this.stateService = stateService;
   }

   @PostMapping("/addState")
   public ResponseEntity<State> addState(@RequestBody State state){
       return ResponseEntity.ok(stateService.addState(state));
   }

   @GetMapping("/getName")
   public ResponseEntity<List<State>> getName(){
       return ResponseEntity.ok(stateService.getState());
   }

   @PutMapping("/editState")
   public ResponseEntity<State> editState(@RequestBody State state){
       return ResponseEntity.ok(stateService.editState(state));
   }

   @DeleteMapping("/deleteState")
   public boolean deleteState(@RequestBody State state){
       int id =state.getId();
       return stateService.deleteState(id);
   }

}
