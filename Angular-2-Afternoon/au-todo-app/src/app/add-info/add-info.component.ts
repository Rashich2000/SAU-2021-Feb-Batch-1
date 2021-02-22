import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {Info} from '../modal/info';
import { InfoService } from '../info.service';
import { MatDialogRef } from '@angular/material/dialog';
import { AuListComponent } from '../au-list/au-list.component';

@Component({
  selector: 'app-add-info',
  templateUrl: './add-info.component.html',
  styleUrls: ['./add-info.component.scss']
})

export class AddInfoComponent implements OnInit {

  infoForm:FormGroup | undefined;

  constructor(
    private service_info:InfoService
    //,public dialogRef:MatDialogRef<AuListComponent> 
    ){}

  ngOnInit(): void {
    //this.infoForm=this._formBuilder;
    this.infoForm = new FormGroup({
      sess_name : new FormControl('', Validators.required),
      instr_name : new FormControl('',Validators.required),
      description: new FormControl('',Validators.required)
    }); 
  }

    get sess_name()
    {
      return this.infoForm?.get('sess_name') as FormControl;
    }
  
    get instr_name(){
      return this.infoForm?.get('instr_name') as FormControl;
    }

    get description(){
      return this.infoForm?.get('description') as FormControl;
    }
  
  
    addToList(){
      const info:Info = {
        session_name : this.sess_name.value,
        instructor_name: this.instr_name.value,
        desc: this.description.value
      }
        this.service_info.addInfo(info);
        //this.dialogRef.close();
    }
    
}

