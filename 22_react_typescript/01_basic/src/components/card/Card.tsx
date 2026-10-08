import type { CardProps } from "./Card.types";
import styles from "./card.module.css";

const Card = ({ title, description, imageUrl }: CardProps) => {
    return (
        <div className={styles.card}>
            <img src={imageUrl} alt="Card Image" />
            <div className={styles.cardDesc}>
                <h4>{title}</h4>
                <p>{description}</p>
            </div>
        </div>
    );
};
export default Card;
