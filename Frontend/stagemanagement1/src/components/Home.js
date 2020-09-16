import React, { useEffect, useReducer, useContext} from "react";
import { AuthContext } from "../App";
import Show from "./Show";

const initialState = {
    shows: [],
    isFetching: false,
    hasError: false,
};

const reducer = (state, action) => {
    switch (action.type) {
      case "FETCH_SHOWS_REQUEST":
        return {
          ...state,
          isFetching: true,
          hasError: false
        };
      case "FETCH_SHOWS_SUCCESS":
        return {
          ...state,
          isFetching: false,
          shows: action.payload
        };
      case "FETCH_SHOWS_FAILURE":
        return {
          ...state,
          hasError: true,
          isFetching: false
        };
      default:
        return state;
    }
};

export const Home = () => {
    const { state: authState } = useContext(AuthContext);
    const [state, dispatch] = useReducer(reducer, initialState);

    useEffect(() => {
        // console.log(authState);
        dispatch({
          type: "FETCH_SHOWS_REQUEST"
        });
        fetch("http://localhost:8080/api/show", {
          headers: {
            Authorization: `Bearer ${authState.token}`
          }
        })
          .then(res => {
           if (res.ok) {
              return res.json();
            } 
            else {
              throw res;
            }
          })
          .then(resJson => {
            console.log(resJson);
            dispatch({
              type: "FETCH_SHOWS_SUCCESS",
              payload: resJson
            });
          })
          .catch(error => {
            console.log(error);
            dispatch({
              type: "FETCH_SHOWS_FAILURE"
            });
          });
    }, [authState.token]);

    return (
        <>
            <div className="home">
              {state.isFetching ? (
                <span className="loader">LOADING...</span>
                ) : state.hasError ? (
                <span className="error">AN ERROR HAS OCCURED</span>
                ) : (
                <>
                  {state.shows.length > 0 &&
                    state.shows.map(oneShow => (
                      <Show key={oneShow.id.toString()} oneShow={oneShow} />
                    ))}
                </>
      )}                    
            </div>
        </>
    );   
};

export default Home;