
export const decorReducer = (state, action) => {
 switch(action.type) {
      case 'ADD_DECOR':
        return [...state, {
            name: action.decor.name,
            department: action.decor.department,
            preset: action.decor.preset,
            description: action.decor.description,
        }]
      case 'REMOVE_DECOR':
        return state.filter(decor => decor.id !== action.id)
      default:
        return state;   
 }   
}


