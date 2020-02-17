package com.structurepoint.point;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Point {
    int x;
    int y;

    @RequestMapping("/")
    @ResponseBody
    public String Submit(@RequestParam String in) {
        String[] arr_in = in.split(",");
        this.x = Integer.valueOf(arr_in[0]);
        this.y = Integer.valueOf(arr_in[1]);
        return "Succesfully added: " + this.x + ", " + this.y;
    }

    @RequestMapping("/C")
    @ResponseBody
    public String detect_cuadrant() {
        String Response = new String(this.x + ", " + this.y );
        if (this.x < 0 && this.y < 0) { // x menor a 0, y menor a cero
            Response = Response + "is in 3rd Cuadrant.";

        } if (this.x < 0 && 0 < this.y) { // x menor a 0, y mayor a cero
            Response = Response + " is in 2nd Cuadrant.";
        } if (0 < this.x && 0 < this.y) {
            Response = Response + " is in 1st Cuadrant.";
        } if (this.x > 0 && this.y < 0 ) {
            Response = Response + " is in 4nd Cuadrant.";
        } else if (this.x == 0 || this.y == 0) {
            Response = Response + " Point is in an axis or is the origin.";
        }
        return Response;
    }
}
