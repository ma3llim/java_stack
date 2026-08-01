import type React from "react";

interface ButtonProps {
    variant: "primary" | "secondary";
    onClick: () => void;
    disabled?: boolean;
    children: React.ReactNode;
}

export type { ButtonProps };
