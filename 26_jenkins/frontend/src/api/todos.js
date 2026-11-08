// Base URL of the backend. Empty means "same origin" (the Vite dev proxy forwards /api).
// Set VITE_API_URL (e.g. http://localhost:8080) to call the backend directly.
const BASE_URL = `${import.meta.env.VITE_API_URL ?? ''}/api/todos`

async function request(path = '', options = {}) {
  const response = await fetch(`${BASE_URL}${path}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  })

  if (!response.ok) {
    let message = `Request failed (${response.status})`
    try {
      const problem = await response.json()
      message = problem.detail || problem.title || message
    } catch {
      // response had no JSON body
    }
    throw new Error(message)
  }

  return response.status === 204 ? null : response.json()
}

export const getTodos = () => request()

export const createTodo = (title) =>
  request('', { method: 'POST', body: JSON.stringify({ title }) })

export const updateTodo = (id, changes) =>
  request(`/${id}`, { method: 'PATCH', body: JSON.stringify(changes) })

export const deleteTodo = (id) => request(`/${id}`, { method: 'DELETE' })

export const deleteCompletedTodos = () =>
  request('/completed', { method: 'DELETE' })
