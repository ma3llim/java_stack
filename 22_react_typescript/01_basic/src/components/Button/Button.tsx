import type { ButtonProps } from "./Button.types";
import styles from "./button.module.css";

const Button = ({ variant, onClick, children, disabled }: ButtonProps) => {
    return (
        <button className={styles[variant]} onClick={onClick} disabled={disabled}>
            {children}
        </button>
    );
};

export default Button;
