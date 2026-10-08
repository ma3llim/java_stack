import type { BedgeProps } from "./Bedge.types";

const Bedge = ({ color, text }: BedgeProps) => {
    return (
        <div className="bedge" style={{ backgroundColor: color }}>
            {text}
        </div>
    );
};
export default Bedge;
