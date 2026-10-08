import type { LoadingSpinnerProps } from "./LoadingSpinner.types";
import styles from "./LoadingSpinner.module.css";

const LoadingSpinner = ({ size = "medium", color = "#007bff", className = "" }: LoadingSpinnerProps) => {
    const sizeMap = {
        small: 20,
        medium: 40,
        large: 60,
    };

    // Get the actual size in pixels
    const pixelSize = typeof size === "number" ? size : sizeMap[size];

    return (
        <div
            className={`${styles.spinnerContainer} ${className}`}
            style={{
                width: pixelSize,
                height: pixelSize,
            }}
        >
            <div
                className={styles.spinner}
                style={{
                    borderColor: `${color} transparent transparent transparent`,
                    width: pixelSize,
                    height: pixelSize,
                }}
            />
        </div>
    );
};

export default LoadingSpinner;
