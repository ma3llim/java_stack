import React from "react"; // ✅ Remove 'type' keyword
import type { InputProps } from "./Input.types";
import styles from "./input.module.css";

const Input = ({ value, label, onChange, error }: InputProps) => {
    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        onChange(e.target.value);
    };

    return (
        <div className={styles.inputWrapper}>
            {label && <label className={styles.label}>{label}</label>} <br />
            <input type="text" value={value} onChange={handleChange} className={`${styles.input} ${error ? styles.inputError : ""}`} />
            {error && <span className={styles.error}>{error}</span>}
        </div>
    );
};

export default Input;
