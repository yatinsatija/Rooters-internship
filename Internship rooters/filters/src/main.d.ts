declare interface Action {
    type: string;
    payload: any;
}

declare interface Filters {
    type:  string[];
}

declare interface AppState {
    filters: Filters;
}

declare interface State {
    app : AppState;
}
