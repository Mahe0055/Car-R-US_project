package ita3.car.api;

import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    IMemberRepository memberRepository;

    //constructor for member repository
    public MemberController(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Read All - members
    @GetMapping("/members")
    public ResponseEntity<List<Member>> index() {
        //The return for find all cars in car repo, will be a 'OK' http status
        return ResponseEntity.status(HttpStatus.OK).body(memberRepository.findAll());
    }

    //Read One - car by id
    @GetMapping("/members/{username}")
    public Optional<Member> readOne(@PathVariable String username){
        return memberRepository.findById(username);
    }

    // Create -> POST
    @PostMapping("/members")
    public Member create(@RequestBody Member member){
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    // Update -> PUT
    @PutMapping("/members/{username}")
    public Member update(@PathVariable String username, @RequestBody Member member){
        Member updatedMember = memberRepository.save(member);
        return updatedMember;
    }

    // Delete -> Delete
    @DeleteMapping("/members/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username){
        memberRepository.deleteById(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
