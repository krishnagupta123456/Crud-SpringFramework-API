package com.example.state.Controller;

import com.example.state.Model.Standard;
import com.example.state.Service.StandardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standards")
@CrossOrigin(origins = "http://localhost:3000")
public class StandardController {
    private final StandardService standardService;

    public StandardController(StandardService standardService) {
        this.standardService = standardService;
    }

    @PostMapping
    public ResponseEntity<Standard> addStandard(@RequestBody Standard standard) {
        return ResponseEntity.ok(standardService.addStandard(standard));
    }

    @GetMapping
    public ResponseEntity<List<Standard>> getAllStandards() {
        return ResponseEntity.ok(standardService.getAllStandards());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Standard> updateStandard(@PathVariable int id, @RequestBody Standard standard) {
        return ResponseEntity.ok(standardService.updateStandard(id, standard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStandard(@PathVariable int id) {
        return ResponseEntity.ok(standardService.deleteStandard(id));
    }
}
