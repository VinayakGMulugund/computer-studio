import { Product } from "./product";

export interface Computer {
  id: number;
  name?: string;
  total_price: number;
  description: string;
  motherboard: Product;
  cpu: Product;
  gpu: Product;
  storage: Product;
  ram: Product;
  psu: Product;
  body: Product;
  imageUrl?: string;
}
