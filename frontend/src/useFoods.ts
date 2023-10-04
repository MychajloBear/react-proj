import {useEffect, useState} from 'react';
import {Food, NewFood} from "./model/Food";
import axios from "axios";
import AddFood from "./components/AddFood";
import FoodGallery from "./components/FoodGallery";

export type UseFoodsReturnType = [String, Food[],
 (newFoodWithoutID: NewFood)=> Promise<any>,
    (FoodIDToDelete: String)=> void]

const a: UseFoodsReturnType= ["0-element of object", [], 0 as any, 0 as any];
console.log(a+'=========useFoods=========='+a[0]);

export default function useFoods(): UseFoodsReturnType {
    const [Foods, setFoods] = useState<Food[]>([])

    useEffect(() => {
        getFoods()
    }, [])

    function getFoods() {
        axios.get("/api/food")
            .then(response => {
                setFoods(response.data)
            })
            .catch(console.error)
    }

    const [Header, setHeader] = useState<String>("")

    useEffect(() => {
        getHeader()
    }, [])

    function getHeader() {
        axios.get("/api/header")
            .then(response => {
                setHeader(response.data)
            })
            .catch(console.error)
    }

    function addFood(newFood: NewFood) {
        return axios.post("/api/food", newFood)
            .then(response => response.data)
            .then((savedFood) => setFoods(prevState => [...prevState, savedFood]))
            .catch(console.error)
    }

    function removeFood(id: String) {
        axios.delete(`/api/food/${id}`)
            .then(() => {
                setFoods(prevState => {
                    return prevState.filter((Food) => Food.id !== id
                    )
                })
            })
    }

//return ([allFoods, filteredFoods]
    return [Header, Foods, addFood, removeFood]

    // <div className={"Food-app"}>
    // <h1 className={"Food-app__title"}>Foods</h1>
    //    <AddFood addFood={addFood}/>
//<FoodGallery Foods={Foods} removeFood={removeFood}/>
//</div>
//)
}
//export default useFoods