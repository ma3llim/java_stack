import { useEffect, useState } from 'react'
import {
  createTodo,
  deleteCompletedTodos,
  deleteTodo,
  getTodos,
  updateTodo,
} from './api/todos'
import './App.css'

const FILTERS = {
  all: () => true,
  active: (todo) => !todo.completed,
  completed: (todo) => todo.completed,
}

function TodoItem({ todo, onToggle, onRename, onDelete }) {
  const [editing, setEditing] = useState(false)
  const [draft, setDraft] = useState(todo.title)

  const save = async () => {
    const title = draft.trim()
    if (title && title !== todo.title) {
      const ok = await onRename(todo.id, title)
      if (!ok) setDraft(todo.title)
    } else {
      setDraft(todo.title)
    }
    setEditing(false)
  }

  return (
    <li className={`todo ${todo.completed ? 'done' : ''}`}>
      <input
        type="checkbox"
        checked={todo.completed}
        onChange={() => onToggle(todo)}
        aria-label={`Mark "${todo.title}" as ${todo.completed ? 'not done' : 'done'}`}
      />
      {editing ? (
        <input
          className="edit"
          value={draft}
          autoFocus
          maxLength={200}
          onChange={(e) => setDraft(e.target.value)}
          onBlur={save}
          onKeyDown={(e) => {
            if (e.key === 'Enter') save()
            if (e.key === 'Escape') {
              setDraft(todo.title)
              setEditing(false)
            }
          }}
        />
      ) : (
        <span className="title" onDoubleClick={() => setEditing(true)} title="Double-click to edit">
          {todo.title}
        </span>
      )}
      <button className="icon" onClick={() => setEditing(true)} aria-label="Edit">
        ✎
      </button>
      <button className="icon danger" onClick={() => onDelete(todo.id)} aria-label="Delete">
        ✕
      </button>
    </li>
  )
}

function App() {
  const [todos, setTodos] = useState([])
  const [title, setTitle] = useState('')
  const [filter, setFilter] = useState('all')
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  // Runs an API call, reporting any failure in the error banner.
  const run = async (action) => {
    setError('')
    try {
      await action()
      return true
    } catch (err) {
      setError(err.message || 'Could not reach the server')
      return false
    }
  }

  const load = () =>
    run(async () => setTodos(await getTodos())).finally(() => setLoading(false))

  // Initial fetch; state is only set once the request settles.
  useEffect(() => {
    getTodos()
      .then(setTodos)
      .catch((err) => setError(err.message || 'Could not reach the server'))
      .finally(() => setLoading(false))
  }, [])

  const handleAdd = async (e) => {
    e.preventDefault()
    const text = title.trim()
    if (!text) return
    const ok = await run(async () => {
      const created = await createTodo(text)
      setTodos((prev) => [...prev, created])
    })
    if (ok) setTitle('')
  }

  const replaceTodo = (updated) =>
    setTodos((prev) => prev.map((t) => (t.id === updated.id ? updated : t)))

  const handleToggle = (todo) =>
    run(async () => replaceTodo(await updateTodo(todo.id, { completed: !todo.completed })))

  const handleRename = (id, newTitle) =>
    run(async () => replaceTodo(await updateTodo(id, { title: newTitle })))

  const handleDelete = (id) =>
    run(async () => {
      await deleteTodo(id)
      setTodos((prev) => prev.filter((t) => t.id !== id))
    })

  const handleClearCompleted = () =>
    run(async () => {
      await deleteCompletedTodos()
      setTodos((prev) => prev.filter((t) => !t.completed))
    })

  const visible = todos.filter(FILTERS[filter])
  const remaining = todos.filter((t) => !t.completed).length
  const completedCount = todos.length - remaining

  return (
    <main className="app">
      <h1>Todos</h1>

      <form className="add" onSubmit={handleAdd}>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="What needs to be done?"
          maxLength={200}
          aria-label="New todo"
        />
        <button type="submit" disabled={!title.trim()}>
          Add
        </button>
      </form>

      {error && (
        <div className="error" role="alert">
          <span>{error}</span>
          <button onClick={load}>Retry</button>
        </div>
      )}

      {loading ? (
        <p className="muted">Loading…</p>
      ) : (
        <>
          <ul className="list">
            {visible.map((todo) => (
              <TodoItem
                key={todo.id}
                todo={todo}
                onToggle={handleToggle}
                onRename={handleRename}
                onDelete={handleDelete}
              />
            ))}
          </ul>
          {visible.length === 0 && (
            <p className="muted">
              {todos.length === 0 ? 'Nothing to do yet. Add your first todo!' : 'No todos here.'}
            </p>
          )}
        </>
      )}

      {todos.length > 0 && (
        <footer className="footer">
          <span>
            {remaining} item{remaining === 1 ? '' : 's'} left
          </span>
          <div className="filters">
            {Object.keys(FILTERS).map((name) => (
              <button
                key={name}
                className={filter === name ? 'active' : ''}
                onClick={() => setFilter(name)}
              >
                {name}
              </button>
            ))}
          </div>
          <button className="link" onClick={handleClearCompleted} disabled={completedCount === 0}>
            Clear completed
          </button>
        </footer>
      )}
    </main>
  )
}

export default App
