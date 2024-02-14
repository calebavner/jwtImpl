package debit.manager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @GetMapping
    public ResponseEntity<String> publicMsg() {
        return ResponseEntity.ok("Hi, this endpoint is for all");
    }
    @PostMapping
    public ResponseEntity<String> admMsg(@RequestBody String name) {
        return ResponseEntity.ok("Hi " + name + ", this endpoint is only adm's");
    }
}
