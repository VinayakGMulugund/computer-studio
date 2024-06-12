import { Order } from "./order";
import { Studio } from "./studio";

export interface User {
    id?: number;
    username?: string;
    password?: string;
    role?: string;
    email?: string;
    orderList?: Order[];
    studio?: Studio;
  }
  