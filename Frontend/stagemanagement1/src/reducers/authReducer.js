export const authReducer = (state, action) => {

    switch (action.type) {
        case "LOGIN":
          // console.log(action.payload);
          localStorage.setItem("user", action.payload.username);
          localStorage.setItem("token", action.payload.accessToken);
          localStorage.setItem("role", action.payload.roles);
          console.log(localStorage);
          return {
            ...state,
            isAuthenticated: true,
            user: action.payload.username,
            token: action.payload.accessToken,
            role: action.payload.roles
          };
        case "LOGOUT":
          localStorage.clear();
          return {
            ...state,
            isAuthenticated: false,
            user: null
          };
        default:
          return state;
    }
}



