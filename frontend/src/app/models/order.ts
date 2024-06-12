import { Computer } from "./computer";
import { User } from "./user";

export interface Order {
    id: number;
    computer: Computer;
    user: User;
    status: string;
    date: Date;
  }
  