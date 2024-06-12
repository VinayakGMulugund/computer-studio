export interface Product {
  id: number;
  name: string;
  description: string;
  category: ProductCategory;
  price: number;
  imageUrl: string;
}

export enum ProductCategory {
    GPU = 'GPU',
    CPU = 'CPU',
    MOTHERBOARD = 'MOTHERBOARD',
    RAM = 'RAM',
    STORAGE = 'STORAGE',
    POWER_SUPPLY = 'POWER_SUPPLY',
    CASE = 'CASE',
    COOLING = 'COOLING'
  }
  