export type Species = 'chien' | 'chat' | 'poisson' | 'lapin';
export interface IPet {
  id: number;
  name:string|undefined;
  species: Species;
  price:number|undefined;
  isAvailable: boolean;
  imageUrl?: string;
  // le point d'interrogation sur une propriété = pas obligatoire
}
