// fonctions
const myNum: number=3;
function addOne(num:number){
    return num+1;
}
console.log(myNum)

// types
const myString: string = 'TypeScript';
const myNumber: number = 10;
const myNum2 = myNumber -2;
const myBoolean: boolean = false;
console.log(myString) ;
const myArrayOfStrings: string[] = ['Angular', 'TypeScript'];
let myNum3 = 3;
//myNum3 = 'coucou'; // Erreur: la variable myNum3 est deja déclarée avec un type number par défaut.

// objet non typé
const myObj = {
    course: 'Angular',
    section: 'TS',
    year: 2022,
    isEasy: true
};

// objet typé, ici c'est "any"
let myObjTypé: any;
type myObjTypé = { // sert à typer chaque attribut
    course: string,
    section: string,
    year: number,
    isEasy: true
}
myObjTypé = {
    course: 'Angular',
    section: 'TS',
    year: 2022,
    isEasy: true
};

//interface myObjTypé = { // interface est un peu comme type. Sert à typer les attributs d'un objet.
//contrairement à une classe, ne peut etre instancié et n'a pas de constructeur.
class myObjTypé2 { // sert à typer chaque attribut
    name: string | undefined;
    section: string | undefined;
    year: number | undefined;
    isEasy: true | undefined;
}

//=====================================
type Species = 'dog' | 'rabbit';
interface IPet {
    id:number;
    name:string;
    species:Species;
}
const medor: IPet = {
    id:1,
    name:'Medor',
    species:'dog'
}
console.log(medor);
class Rabbit implements IPet {
    id: number;
    name:string;
    species:Species;
    constructor(rabbitId:number, rabbitName:string) {
        this.id=rabbitId;
        this.name=rabbitName;
        this.species='rabbit';
    }
}
const roger: IPet = new Rabbit(1, 'roger');
console.log(roger);

//=====================================
class Car {
    constructor (public brand:string){
    }
}
const myCar: Car = new Car('Renault');
console.log(myCar.brand);

//=====================================
// NgModules/AppModules: application divisée en plusieurs modules, 
// permet d'echanger fonctionnalités et composants.
