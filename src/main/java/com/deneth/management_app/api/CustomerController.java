package com.deneth.management_app.api;

import com.deneth.management_app.dto.request.CustomerRequestDto;
import com.deneth.management_app.dto.response.CustomerResponseDto;
import com.deneth.management_app.service.CustomerService;
import com.deneth.management_app.util.StandardResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @PostMapping
    public ResponseEntity<StandardResponseDto>
    create(

            @RequestBody CustomerRequestDto dto){
        CustomerResponseDto data = service.createCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        201,"customer has been saved!",data
                ),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseDto>
    update(
            @RequestBody CustomerRequestDto dto,
            @PathVariable String id
    ){
        CustomerResponseDto data = service.updateCustomer(dto,id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        201,"customer has been updated!",data
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponseDto>
    delete(
            @PathVariable String id
    ){
        service.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        204,"customer has been deleted!",null
                ),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<StandardResponseDto>
    findById(
            @PathVariable String id
    ){
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "customer found!",
                        service.getCustomer(id)
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/search")
    public ResponseEntity<StandardResponseDto>
    search(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "customer list!",
                        service.search(searchText, page, size)
                ),
                HttpStatus.OK
        );
    }

    @PutMapping("/change-state/{id}")
    public ResponseEntity<StandardResponseDto>
    changeState(
            @PathVariable String id
    ){
        service.manageStatus(id);
        return new ResponseEntity<>(
                new StandardResponseDto(
                        200,
                        "customer status changed!",null
                ),
                HttpStatus.OK
        );
    }
}
