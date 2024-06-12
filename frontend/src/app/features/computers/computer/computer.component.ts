import { Component, Input } from '@angular/core';
import { trigger, state, style, animate, transition } from '@angular/animations';
import { CommonModule } from '@angular/common';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { ComputerDetailsDialogComponent } from '../computer-detail/computer-detail.component';
import { Computer } from '../../../models/computer';

@Component({
  selector: 'app-computer',
  templateUrl: './computer.component.html',
  standalone: true,
  styleUrl: './computer.component.css',
  imports: [CommonModule, MatDialogModule, ComputerDetailsDialogComponent],
  animations: [
    trigger('cardHover', [
      state('default', style({
        transform: 'scale(1)',
      })),
      state('hover', style({
        transform: 'scale(1.05)',
      })),
      transition('default <=> hover', [
        animate('0.3s ease-in-out')
      ])
    ])
  ]
})
export class ComputerComponent {
  @Input() computer: Computer | undefined;
  hoverState = 'default';

  constructor(private readonly dialog: MatDialog) {}

  onMouseEnter() {
    this.hoverState = 'hover';
  }

  onMouseLeave() {
    this.hoverState = 'default';
  }

  openDialog(): void {
    this.dialog.open(ComputerDetailsDialogComponent, {
      width: '1300px',
      height: '650px',
      data: this.computer
    });
  }
}
