import Redux from 'redux';

export default function logger({ getState, dispatch } : Redux.MiddlewareAPI) {
    return (next: any) => (action: Action) => {
      console.log('will dispatch', action)
  
      // Call the next dispatch method in the middleware chain.
      const returnValue = next(action)
  
      console.log('state after dispatch', getState())
  
      // This will likely be the action itself, unless
      // a middleware further in chain changed it.
      return returnValue
    }
}