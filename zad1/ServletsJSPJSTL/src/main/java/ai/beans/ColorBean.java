package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private boolean shouldEdgesBeVisible;

    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the shouldEdgesBeVisible
     */
    public boolean isShouldEdgesBeVisible() {
        return shouldEdgesBeVisible;
    }

    /**
     * @param shouldEdgesBeVisible the shouldEdgesBeVisible to set
     */
    public void setShouldEdgesBeVisible(boolean shouldEdgesBeVisible) {
        this.shouldEdgesBeVisible = shouldEdgesBeVisible;
    }
}
