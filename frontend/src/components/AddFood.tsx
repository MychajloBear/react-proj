import {NewFood} from "../model/Food";
import {Food} from "../model/Food";
import FoodGallery from "./FoodGallery";
import useFoods from "../useFoods";
import {type UseFoodsReturnType} from "../useFoods";
import {ChangeEvent, useState} from "react";
import "./AddFood.css"

type AddFoodProps = {
    addFood: (newFood: NewFood) => Promise<any>
}

type Entity = { name: String; id: String; }
const entity3: Entity = {name: "M", id: "0"};
const entity2: Entity = {name: "Milk", id: "1"};
const entities: {name: String; id: String;}[] = [entity2, entity2, entity2];
const updatedEntities = (entities: {name: String; id: String;}[], id: String, newName: String): {name: String; id: String;}[] => {
return entities.map((entity) => { if (entity.id === '0') { entity.name='NULL'} return entity})}
console.log(entities);
const newList = updatedEntities(entities, '0', 'NULL');
console.log(entities);
console.log(newList);


export type UseShortFoodsReturnType = [Food[],
 (newFoodWithoutID: NewFood)=> Promise<any>,
    (FoodIDToDelete: String)=> void]

export interface UseFoodsReturnType2 {
        property1: String;
        property2: String;
    }

    function createUseFoodsReturnType(sourceObject: UseFoodsReturnType): UseFoodsReturnType {
        const emptyUseFoodsReturnType: UseFoodsReturnType = [
            "",
            [],
            (newFoodWithoutID: NewFood) => Promise.resolve(),
            (FoodIDToDelete: String) => {}
        ];
        const interfaceProperties = Object.keys(emptyUseFoodsReturnType);
        const targetObject: UseFoodsReturnType = Object.assign([], sourceObject);

        for (let property of Object.keys(targetObject)) {
            if (interfaceProperties.indexOf(property) < 0) {
                console.log(property);
            }
        }
        return targetObject;
    }

export default function AddFood(props: AddFoodProps) {

    const [name, setName] = useState<String>("")
    const useFoodComponent:UseFoodsReturnType = useFoods();
    var keys = Object.keys( useFoodComponent[0] );

    const a: UseFoodsReturnType= ["hello", [], 0 as any, 0 as any];
    const b = a[0];
    console.log(a+'----------------addFood.tsx--------------------'+b);
    console.log(useFoodComponent);

    const useShortFoodComponent : UseShortFoodsReturnType = [useFoodComponent[1], useFoodComponent[2], useFoodComponent[3]];
    function onNameChange(event: ChangeEvent<HTMLInputElement>) {
        setName(event.target.value)
    }

    function onSaveClickRefresh() {
        onSaveClick();
        window.location.reload();
    }

    function onSaveClick() {
        props.addFood({name: name})
            .then(() => {
                setName("")
            })        
    }

    return (
        <div>
            <input className={"add-food__name"} placeholder={"Name"} value={name as string} onChange={onNameChange}/>
            <button className={"add-food__button"} onClick={onSaveClick}>Save</button>
            <FoodGallery showedComponents={useShortFoodComponent[0]} removeFood={useFoodComponent[3]}/>
        
        </div>
    )

}
