import { Product } from "./product";
import { User } from "./user";

export interface Studio {
    id: number;
    user: User;
    motherboard: Product;
    cpu: Product;
    gpu: Product;
    storage: Product;
    ram: Product;
    psu: Product;
    body: Product;
  }
  