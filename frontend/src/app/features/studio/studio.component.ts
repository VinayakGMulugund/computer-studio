import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RouterModule } from '@angular/router';
import { PartDialogComponent } from './part-dialog/part-dialog.component';

@Component({
  selector: 'app-studio',
  standalone: true,
  imports: [CommonModule, RouterModule, MatDialogModule],
  templateUrl: './studio.component.html',
  styleUrl: './studio.component.css'
})
export class StudioComponent {

  components: {[key: string]: any} = {
    cpu: null,
    gpu: null,
    motherboard: null,
    ram: null,
    storage: null,
    psu: null,
    body: null,
  };

  componentKeys = ['cpu', 'gpu', 'motherboard', 'ram', 'storage', 'psu', 'body'];

  addProductToStudio(prod: any, cat:any) {}

  saveStudio() {}
  constructor(public dialog: MatDialog) {}

  openDialog(componentType: string): void {
    const dialogRef = this.dialog.open(PartDialogComponent, {
      width: '600px',
      data: { type: componentType }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.components[componentType] = result;
      }
    });
  }

  getComponentName(key: string) {
    // return this.components[key]?.name;
    return "name";
  }
}
