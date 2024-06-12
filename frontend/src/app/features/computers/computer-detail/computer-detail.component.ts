import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { Computer } from '../../../models/computer';
import { CartService } from '../../../core/services/api-service/cart.service';

@Component({
  selector: 'app-computer-details-dialog',
  standalone: true,
  imports: [MatIconModule, MatDialogModule, CommonModule],
  templateUrl: './computer-detail.component.html',
  styleUrl: './computer-detail.component.css'
})
export class ComputerDetailsDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<ComputerDetailsDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Computer
  ) { }

  onClose(): void {
    this.dialogRef.close();
  }

  computerParts = [
    { name: 'Motherboard', key: 'motherboard', icon: 'developer_board' },
    { name: 'CPU', key: 'cpu', icon: 'cpu' },
    { name: 'RAM', key: 'ram', icon: 'memory' },
    { name: 'Storage', key: 'storage', icon: 'storage' },
    { name: 'PSU', key: 'psu', icon: 'power_input' },
    { name: 'GPU', key: 'gpu', icon: 'desktop_mac' },
    { name: 'Case', key: 'body', icon: 'computer' }
  ];
  getPartName(partKey: any): string {
    const key = partKey as keyof Computer;
    return (this.data[key] as { name: string }).name;
  }

  addToCart() {
    // this.cartService.addComputerToCart(this.data);
  }
}
