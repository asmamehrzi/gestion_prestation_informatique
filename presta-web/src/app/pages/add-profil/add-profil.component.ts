import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import { ProfilService } from 'src/app/services/profil.service';

@Component({
  selector: 'app-add-profil',
  templateUrl: './add-profil.component.html',
  styleUrls: ['./add-profil.component.css']
})
export class AddProfilComponent implements OnInit {
registerForm: FormGroup=this.formBuilder.group({
    titre: ['', Validators.required],
    description: ['', Validators.required],

    })
  constructor(private profilService: ProfilService,
    private router: Router,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }
  onSubmit() {
    this.profilService
    .createCompetance(this.registerForm.value)
    .subscribe(data => {
      console.log(this.registerForm.value)
      this.registerForm.reset();
      alert("signup successfull");
      this.router.navigate(['profil']);

    },
    error => console.log(error));
  }



}
