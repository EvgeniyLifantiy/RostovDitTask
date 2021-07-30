package com.Sberbank.RostovDitTast.Controller;

import com.Sberbank.RostovDitTast.Entity.Box;
import com.Sberbank.RostovDitTast.Service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Евгений
 * @project RostovDitTast
 */
@Controller
public class BoxController {

    private final BoxService boxService;

    @Autowired
    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping("/getAllBoxes")
    public List<Box> getAllBoxes(){
        return boxService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Box getBoxById(@PathVariable Long id){
        Box box1 = boxService.getById(id);
        Box box2 = new Box();
        box2.setBarcode(box1.getBarcode());
        box2.setName(box1.getName());
        box2.setBox_id(box1.getBox_id());
        box2.setDocuments(box1.getDocuments());
        return box2;
    }

    @PostMapping("/createBox")
    public ResponseEntity<Box> createBox(@RequestBody Box box){
        return ResponseEntity.ok(boxService.create(box));
    }

    @PutMapping("/updateBox")
    public Box updateBox(@RequestBody Box box){
        return boxService.update(box);
    }

}

