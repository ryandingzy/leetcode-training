class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        double midax = ((double)ax1 + (double)ax2) / 2;
        double miday = ((double)ay1 + (double)ay2) / 2;
        double midbx = ((double)bx1 + (double)bx2) / 2;
        double midby = ((double)by1 + (double)by2) / 2;
        double wa = Math.abs(ax1 - ax2);
        double ha = Math.abs(ay1 - ay2);
        double wb = Math.abs(bx1 - bx2);
        double hb = Math.abs(by1 - by2);
        double wmid = Math.abs(midax - midbx);
        double hmid = Math.abs(miday - midby);
        if (wmid > wa / 2 + wb / 2 || hmid > ha / 2 + hb / 2) return (int)(wa * ha + wb * hb);
        double w, h;
        if (wmid + Math.min(wa, wb) / 2 <= Math.max(wa, wb) / 2) w = Math.min(wa, wb);
        else w = wa / 2 + wb / 2 - wmid;
        if (hmid + Math.min(ha, hb) / 2 <= Math.max(ha, hb) / 2) h = Math.min(ha, hb);
        else h = ha / 2 + hb / 2 - hmid;
        return (int)(wa * ha + wb * hb - w * h);
    }
}
