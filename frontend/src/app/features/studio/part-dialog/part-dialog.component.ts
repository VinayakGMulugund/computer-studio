import { CommonModule } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-part-dialog',
  standalone: true,
  imports: [MatDialogModule, CommonModule],
  templateUrl: './part-dialog.component.html',
  styleUrl: './part-dialog.component.css'
})
export class PartDialogComponent {

  products: { name: string, category: string, price: number, description: string, imageUrl: ""}[] = [
    { name: "name", category: "cpu", price: 999, description: "skjdmfkjsndfkjsndfkjnsdkfjnskdjfnksjdf", imageUrl: ""}
  ];

  constructor(
    public dialogRef: MatDialogRef<PartDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { type: string }
  ) {
    this.loadProducts(data.type);
  }

  loadProducts(type: string) {
    // this.productService.getProductsByType(type).subscribe((products: any) => {
    //   this.products = products;
    // });
  }

  onSelect(product: any): void {
    this.dialogRef.close(product);
  }

  onCancel(): void {
    this.dialogRef.close();
  }
}
