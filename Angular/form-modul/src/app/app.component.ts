import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  loginForm: FormGroup = this.fb.group({
    email: ['', Validators.required], // email requis pour pouvoir valider
    password: ['', [Validators.required, Validators.minLength(6)]], // on ne peut pas s'inscrire si le mot de passe contient moins de 6 char
    firstName: 'Jeremy',
    lastName: 'Rio',
    age: [null, Validators.min(18)], // inscription impossible si -18ans
  });
  constructor(private fb: FormBuilder){}

  onSubmit(){
    console.log(this.loginForm); //loginForm.value se restreint aux valeurs remplies du formulaire
    if(this.loginForm.valid){
      console.log('appel service');

      // Je passe this.loginForm.value à une méthode de mon service pour créer un objet IPet


    }
    else {
      alert('le formulaire est invalide');
    }
  }
}
