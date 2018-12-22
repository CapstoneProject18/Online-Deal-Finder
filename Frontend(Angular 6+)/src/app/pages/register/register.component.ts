import { Component, OnInit, ElementRef } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { DataService } from '../../provider/data.service';
import { stringify } from 'querystring';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  imgRes:string;

  user:{
    name:string,
    email:string,
    pass:string,
    imgUrl:string
  };

  selectedFile: FileList;
  registerForm: FormGroup
  constructor(public data:DataService, private elem:ElementRef ) {    
  }
  

  createFormGroup() {
    return new FormGroup({
        name:new FormControl(),
        email:new FormControl(),
        pass:new FormControl(),
        imgUrl:new FormControl()

    });
  }

  register()
  {
    console.log(this.registerForm);
    this.data.registerUser(this.registerForm.value, this.selectedFile.item(0))
      .subscribe(response =>{
        console.log(response);
        alert('success');
      }, error => {
        console.log("error!!");
      });
  }
  ngOnInit() {
    this.registerForm = this.createFormGroup();

    var body = document.getElementsByTagName('body')[0];
    body.classList.add('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.add('navbar-transparent');
}
ngOnDestroy(){
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.remove('navbar-transparent');
}

selectFile(event) {
  this.selectedFile = event.target.files;
}
}
