import initialState from "./initialState";

const reducer: (state: Filters, action: Action) => Filters = (state : Filters = initialState, action: Action) => {
    const { type, payload } = action;
    switch (type) {
        case 'change-bus-type':
            return { ...state, type: payload }
        default:
            return state
    }
};

export default reducer;